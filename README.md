# API Backend for inqueritos

Este projeto implementa as APIs usadas pela aplicação react de inquéritos aos estudantes do DEISI

Em dev, arranca no porto 8010 (ver inqueritos.properties)

## Preparação para um novo semestre (inquérito)

* Atualizar ano/semestre no inqueritos.properties (está na máquina do deisi em /opt/tomcat/conf)
* Reiniciar tomcat
* Aceder a /admin para sincronizar
* Verificar em /admin/profs
* Obter os links em /admin/disc

(Obsoleto)
* Inserir professores novos diretamente na BD
* Usar a página localhost:8010/admin/profs para:
  * Copiar primeiro as associações do ano anterior
  * Corrigir manualmente na BD as que mudaram

### Endpoints da aplicação DSDeisi
* disciplinas em funcionamento num ano lectivo
   * https://dsdeisi.pythonanywhere.com/inqueritos-courses/24-25/pwd
   * variáveis da rota: ano lectivo (e.g., 24-25), password
* docentes das disciplinas em funcionamento num determinado semestre de um ano lectivo
   * https://dsdeisi.pythonanywhere.com/inqueritos-teacher-courses/24-25/1/pwd
   * variáveis da rota: ano lectivo (e.g., 24-25), semestre (e.g., 1), password
* docentes que lecionam num determinado ano lectivo, fornecendo info do nome, ID da base de dados e numero de docente
   * https://dsdeisi.pythonanywhere.com/inqueritos-teachers/24-25/pwd
   * variáveis da rota: ano lectivo (e.g., 24-25), password

 ### Gerador de Qrcodes
* A página https://deisi.ulusofona.pt/inqueritos/admin/disc disponibiliza os nomes das disciplinas e links para inquéritos
* Com base na informação dessa página, são criados, para cada disciplina, um QRcode para o respectivo link do inquérito
* código: https://github.com/DEISI-ULHT/back-inqueritos-alunos/blob/master/inqueritos-geradorQRcodes.ipynb

