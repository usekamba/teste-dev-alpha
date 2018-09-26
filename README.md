Dev Web Fullstack (Ruby On Rails)
Boas

Para o funcionamento do projecto tera que ter a configuração de RubyonRails e RailsJS na maquina


Depois da aprovação da PR, vai se executar as seguintes instruções:

#Configurações para o back-end

cd teste-dev-alpha
bundle install  #comando para instalar todas as dependencias da parte back-end
rails db:create #comando para criar a BD de teste
rails db:migrate #comando para rodar as migrações

#Configurações para o front-end

Dentro da pasta teste-dev-alpha, vamos executar os seguintes comandos:
cd client
yarn install #comando para instalar as dependencias do front-end

Se tudo correr bem, vamos para a ultima parte
gem install foreman #este comando vai instalar o foreman para poder correr as tasks que estão no file Procfile.

Finalmente:
foreman start #Este comando vai levantar o servidor de back-end e front-end

Acesse http://localhost:3000/