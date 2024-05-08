# API Backend for inqueritos

Este projeto implementa as APIs usadas pela aplicação react de inquéritos aos estudantes do DEISI

Em dev, arranca no porto 8010 (ver inqueritos.properties)

## Preparação para um novo semestre (inquérito)

* Atualizar ano/semestre no inqueritos.properties
* Aceder a /admin para sincronizar
* Verificar em /admin/profs
* Obter os links em /admin/disc

(Obsoleto)
* Inserir professores novos diretamente na BD
* Usar a página localhost:8010/admin/profs para:
  * Copiar primeiro as associações do ano anterior
  * Corrigir manualmente na BD as que mudaram