class Rack::Attack
  Rack::Attack.cache.store = ActiveSupport::Cache::MemoryStore.new
  safelist('allow-localhost') do |req|
   '127.0.0.1' == req.ip || '::1' == req.ip
  end

  throttle('req/ip', limit: 5, period: 5) do |req|
   req.ip
  end

  # Throttle login attempts by email address
  #throttle("logins/email", limit: 5, period: 20.seconds) do |req|
  #  if req.path == '/users/sign_in' && req.post?
  #    req.params['email'].presence
  #  end
  #end
end
