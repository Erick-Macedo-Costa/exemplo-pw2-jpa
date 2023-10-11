SELECT * FROM bd_mapeamento.consulta;
INSERT INTO bd_mapeamento.consulta (ID, data, observacao, valor, medico_id, paciente_id) VALUES
                    (1, '2023-08-31', 'Consulta de rotina', 150.00, 4, 1),
                    (2, '2023-09-05', 'Acompanhamento pós-operatório', 200.00, 3, 2),
                    (3, '2023-09-10', 'Exame de sangue', 50.00, 3, 2);
SELECT * FROM bd_hospital.pessoa;
INSERT INTO bd_hospital.pessoa (tipo, nome, crm) VALUES
                 ('M', 'Hellen', 'CRM12345'),
                 ('M', 'Ana', 'CRM67890'),
                 ('M', 'Larissa', 'CRM54321');
INSERT INTO bd_hospital.pessoa (tipo, nome, telefone) VALUES
                  ('P', 'Joao', '123-456-7890'),
                  ('P', 'Carlos', '987-654-3210'),
                  ('P', 'Edilson', '555-555-5555');