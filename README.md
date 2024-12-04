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
   * https://dsdeisi.pythonanywhere.com/inqueritos-courses/24-25
   * parâmetro: ano lectivo 24-25
* docentes das disciplinas em funcionamento num determinado semestre de um ano lectivo
   * https://dsdeisi.pythonanywhere.com/inqueritos-teacher-courses/24-25/1
   * parâmetro: ano lectivo (24-25)
* docentes que lecionam num determinado ano lectivo, fornecendo info do nome, ID da base de dados e numero de docente
   * https://dsdeisi.pythonanywhere.com/inqueritos-teachers/24-25
   * parâmetro: ano lectivo (24-25)

 ### Qrcodes
* Gerador de qrcodes com link para o inquérito de cada disciplina
