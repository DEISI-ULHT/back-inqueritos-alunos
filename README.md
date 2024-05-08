# API Backend for inqueritos

Este projeto implementa as APIs usadas pela aplicação react de inquéritos aos estudantes do DEISI

Em dev, arranca no porto 8010 (ver inqueritos.properties)

## Preparação para um novo semestre (inquérito)

* Inserir professores novos diretamente na BD
* Usar a página localhost:8010/admin/profs para:
  * Copiar primeiro as associações do ano anterior
  * Corrigir manualmente na BD as que mudaram


- Atualizar tabela de cursos
- ALTER TABLE curso_disciplina MODIFY COLUMN id BIGINT AUTO_INCREMENT;
- ALTER TABLE professor_disciplina MODIFY COLUMN id BIGINT AUTO_INCREMENT;
- update professor_disciplina set semestre = 1 where semestre is null;
- ALTER TABLE disciplina MODIFY nome VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;