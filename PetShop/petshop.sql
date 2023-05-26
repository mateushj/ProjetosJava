DROP SCHEMA IF EXISTS Pet23;
CREATE SCHEMA Pet23;
USE Pet23;
create table usuarios(
id int primary key auto_increment,
email varchar(100) not null,
senha varchar(100) not null,
perfil varchar(10) not null
);
INSERT INTO usuarios(id,email,senha,perfil)VALUES
(1,'mateus','admin','admin'),
(2,'teste','teste','p1');
create table enderecos(
id int primary key auto_increment,
logradouro varchar(100) not null,
numero int not null,
bairro varchar(100) not null,
cep bigint not null,
cidade varchar(100) not null,
estado varchar(2) not null,
complemento varchar(50) not null
);
INSERT INTO ENDERECOS(logradouro,numero,bairro,cep,cidade,estado,complemento)VALUES
('Rua das Flores',120,'Centro',34323333,'São Paulo','SP','casa'),
('Rua Jatobá',90,'Alto Barreiro',454567323,'Rio de Janeiro','RJ','casa'),
('Rua das Folhas',20,'Casa Nova',451211122,'Rio de Janeiro','RJ','Loja 03'),
('Rua Campos Altos',11,'Virtudes',400090009,'Rio de Janeiro','RJ','Galpão 10 setor L'),
('Rua Olegário Firmino',1210,'Vieiras',786667545,'Belo Horizonte','MG','casa'),
('Rua Bahia Nova',912,'Dom Castelo',034334444,'Belo Horizonte','MG','casa'),
('Rua Conde de Luna',232,'Centro',576665665,'Contagem','MG','Apartamento'),
('Rua Maria Manta',544,'Centro',299989998,'Belo Horizonte','MG','casa'),
('Rua Gomes Talvis',544,'Otoni',102938475,'Belo Horizonte','MG','casa'),
('Rua Padoca Nova',392,'Cascata',122232226,'Belo Horizonte','MG','Apartamento'),
('Av Vargem Livre',2980,'Olivio Nunes',3444566778,'Belo Horizonte','MG','casa'),
('Av cruz de Lima',100,'Centro',344455545,'Contagem','MG','Apartamento'),
('Av Maestro Campos',2881,'Centro',888777990,'Betim','MG','Apartamento'),
('Av Comospolita',7901,'Madeira',23334445456,'Contagem','MG','Apartamento'),
('Av Coronel Tinta',3801,'Silo Novo',676668776,'Belo Horizonte','MG','casa'),
('Av das Gerais',2188,'Altas Montanhas',4544443333,'Betim','MG','casa'),
('Av candida Maltina',1222,'Centro',2223332222,'Belo Horizonte','MG','casa'),
('Av Consagrada',490,'Costa',566676666,'Belo Horizonte','MG','casa'),
('Av das Lombadas',311,'Centro',122211111,'Betim','MG','Apartamento');
create table clientes(
id int primary key auto_increment,
nome varchar(100) not null,
cpf bigint not null,
email varchar(100) not null,
telefone  varchar(20) not null,
data_Nascimento Date,
endereco_id int not null
);
create table funcionarios(
id int primary key auto_increment,
nome varchar(100) not null,
cpf bigint not null,
rg bigint not null,
email varchar(100) not null,
telefone varchar(20) not null,
data_Nascimento Date not null,
cargo varchar(50) not null,
salario double not null,
endereco_id int not null
);
create table fornecedores(
id int primary key auto_increment,
razao_Social varchar(30) not null,
cnpj bigint not null,
insc_Estadual bigint not null,
telefone varchar(30) not null,
email varchar(30) not null,
endereco_id int not null
);
create table animais(
id int primary key auto_increment,
nome varchar(100) not null,
raca varchar(50) not null,
sexo varchar(2) not null,
data_Nascimento Date,
tutor int not null
);
create table produtos(
id int primary key auto_increment,
descricao varchar(100) not null,
preco_Unitario double not null,
preco_Venda double not null,
estoque int not null,
vencimento Date not null
);
create table servicos(
id int primary key auto_increment,
descricao varchar(100) not null,
tempo_Gasto varchar(30) not null,
responsavel int not null,
data_inicio datetime not null,
data_fim datetime not null,
valor  double not null
);
create table pix(
id int primary key auto_increment,
codigo varchar(100) not null
);
create table debito(
id int primary key auto_increment,
numero_Cartao bigint not null,
cod_Seguranca int not null,
vencimento_Cartao varchar(5) not null,
juros double
);
create table dinheiro(
id int primary key auto_increment,
desconto double
);
create table credito(
id int primary key auto_increment,
numero_Cartao bigint not null,
cod_Seguranca int not null,
vencimento_Cartao varchar(5) not null,
parcelas int not null,
juros double

);
create table pagamentos(
id int primary key auto_increment,
credito_id int not null,
debito_id int not null,
pix_id int not null,
dinheiro_id int not null
);
create table vendas(
id int primary key auto_increment,
cliente_id int not null,
data_Venda Date not null,
hora_venda Date not null,
responsavel int not null,
forma_Pagamento int not null,
valor_Total double not null
);
create table itens_vendas(
id int primary key auto_increment,
produto_id int not null,
servico_id int not null,
venda_id int not null,
quantidade int not null
);
create table consultas(
id int primary key auto_increment,
animal_id int not null,
funcionario_id int not null,
data_Consulta date not null,
hora_Consulta time not null,
retorno varchar(100) not null,
prescricao varchar(100) not null,
exame_id int not null
);
create table exames(
id int primary key auto_increment,
descricao varchar(100) not null,
data_Exame date not null,
resultado_Exame varchar(100) not null
);

ALTER TABLE clientes ADD CONSTRAINT clientesFK
FOREIGN KEY(endereco_id)REFERENCES enderecos(id);
ALTER TABLE funcionarios ADD CONSTRAINT funcionariosFK
FOREIGN KEY(endereco_id)REFERENCES enderecos(id);
ALTER TABLE fornecedores ADD CONSTRAINT fornecedoresFK
FOREIGN KEY(endereco_id)REFERENCES enderecos(id);
ALTER TABLE animais ADD CONSTRAINT animaisFK
FOREIGN KEY(tutor)REFERENCES clientes(id);

ALTER TABLE pagamentos ADD CONSTRAINT pagamentosFK1
FOREIGN KEY(credito_id)REFERENCES credito(id);
ALTER TABLE pagamentos ADD CONSTRAINT pagamentosFK2
FOREIGN KEY(debito_id)REFERENCES debito(id);
ALTER TABLE pagamentos ADD CONSTRAINT pagamentosFK3
FOREIGN KEY(pix_id)REFERENCES pix(id);
ALTER TABLE pagamentos ADD CONSTRAINT pagamentosFK4
FOREIGN KEY(dinheiro_id)REFERENCES dinheiro(id);

ALTER TABLE vendas ADD CONSTRAINT vendasFK
FOREIGN KEY(cliente_id)REFERENCES clientes(id);
ALTER TABLE vendas ADD CONSTRAINT vendasFK2
FOREIGN KEY(forma_Pagamento)REFERENCES pagamentos(id);

ALTER TABLE itens_vendas ADD CONSTRAINT itensVendasFK1
FOREIGN KEY(produto_id)REFERENCES produtos(id);
ALTER TABLE itens_vendas ADD CONSTRAINT itensVendasFK2
FOREIGN KEY(servico_id)REFERENCES servicos(id);
ALTER TABLE itens_vendas ADD CONSTRAINT itensVendasFK3
FOREIGN KEY(venda_id)REFERENCES vendas(id);

ALTER TABLE consultas ADD CONSTRAINT consultasFK
FOREIGN KEY(exame_id)REFERENCES exames(id);
