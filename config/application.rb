require_relative 'boot'

require 'rails/all'

# Require the gems listed in Gemfile, including any gems
# you've limited to :test, :development, or :production.
Bundler.require(*Rails.groups)

module TesteDevAlpha
  class Application < Rails::Application
    # Initialize configuration defaults for originally generated Rails version.
    config.load_defaults 5.2
    config.middleware.use Rack::Attack

    config.middleware.insert_before 0, Rack::Cors do
      allow do
        origins '*'
        resource '*',
        headers: :any,
        methods: %i(get post put patch delete options head)
      end
    end

  end
end
