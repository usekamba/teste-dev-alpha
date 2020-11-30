Rails.application.routes.draw do
    namespace :api, defaults: {format: :json} do
        namespace :v1, defaults: {format: :json} do
            resources :kambas, only: [:index]
        end
    end
end
