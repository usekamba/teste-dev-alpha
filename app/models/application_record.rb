class ApplicationRecord < ActiveRecord::Base
  self.abstract_class = true
  include HTTParty

  # Retorna dos os itens que estao na API TESTE
  def activities
    HTTParty.get("https://kamba-api-staging.herokuapp.com/v1/users/activities", headers: {"Authorization" => "Token token=\"VS7elyzN7ZqMNcQmQA5Cjgtt\""})
  end

end
