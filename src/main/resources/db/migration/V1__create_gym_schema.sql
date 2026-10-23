CREATE TABLE alunos (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sexo VARCHAR(10) CHECK ( sexo in ('M', 'F')) NOT NULL,
    data_nascimento DATE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(15),
    telemovel VARCHAR(15) NOT NULL,
    morada VARCHAR(200) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    codigo_postal VARCHAR(10) NOT NULL,
    observacoes TEXT,
    complemento VARCHAR(100),
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP
);

CREATE TABLE modalidades (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) UNIQUE NOT NULL,
    ativa BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE categorias (
    id BIGSERIAL PRIMARY KEY,
    modalidade_id BIGINT NOT NULL REFERENCES modalidades(id),
    nome VARCHAR(100) NOT NULL,
    UNIQUE (modalidade_id, nome)
);

CREATE TABLE planos (
    id BIGSERIAL PRIMARY KEY,
    modalidade_id BIGINT NOT NULL REFERENCES modalidades(id),
    nome VARCHAR(100) NOT NULL,
    valor_mensal DECIMAL(10, 2) NOT NULL CHECK ( valor_mensal >= 0),
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    UNIQUE (modalidade_id, nome)
);

CREATE TABLE matriculas (
    id BIGSERIAL PRIMARY KEY,
    aluno_id BIGINT NOT NULL REFERENCES alunos(id),
    data_inicio DATE NOT NULL DEFAULT CURRENT_DATE,
    dia_vencimento INT NOT NULL CHECK ( dia_vencimento BETWEEN 1 AND 31),
    data_fim DATE,
    estado VARCHAR(20) CHECK ( estado in ('ATIVA', 'ENCERRADA', 'CANCELADA')) NOT NULL DEFAULT 'ATIVA',
    ativo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE matriculas_modalidades (
    id BIGSERIAL PRIMARY KEY,
    matricula_id BIGINT NOT NULL REFERENCES matriculas(id),
    modalidade_id BIGINT NOT NULL REFERENCES modalidades(id),
    categoria_id BIGINT NOT NULL REFERENCES categorias(id),
    plano_id BIGINT NOT NULL REFERENCES planos(id),
    data_inicio DATE NOT NULL DEFAULT CURRENT_DATE,
    data_fim DATE,
    UNIQUE (matricula_id, modalidade_id)
);

CREATE TABLE faturas_matriculas (
    id BIGSERIAL PRIMARY KEY,
    matricula_id BIGINT NOT NULL REFERENCES matriculas(id),
    data_vencimento DATE,
    valor DECIMAL(10, 2) NOT NULL CHECK ( valor >= 0),
    data_pagamento TIMESTAMP,
    data_cancelamento DATE,
    estado VARCHAR(20) CHECK ( estado in ('PENDENTE', 'PAGA', 'CANCELADA', 'VENCIDA')) NOT NULL DEFAULT 'PENDENTE',
    UNIQUE (matricula_id, data_vencimento)
);

CREATE TABLE assiduidade (
    id BIGSERIAL PRIMARY KEY,
    matricula_id BIGINT NOT NULL REFERENCES matriculas(id),
    data_entrada TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_saida TIMESTAMP
);