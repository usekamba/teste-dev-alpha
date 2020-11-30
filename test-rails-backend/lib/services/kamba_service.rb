require "net/https"
require "uri"
require "json"

module Services
    class KambaService
        def self.request
            uri  = URI.parse("https://kamba-api-staging.herokuapp.com")
            http = Net::HTTP.new(uri.host, uri.port)

            http.use_ssl = true
            http.verify_mode = OpenSSL::SSL::VERIFY_NONE

            request = Net::HTTP::Get.new("/v1/users/activities",{
                "Content-Type" => "application/json", 
                "Authorization" => "Token VS7elyzN7ZqMNcQmQA5Cjgtt"
            })
            response = http.request(request).body
            JSON.parse response
        rescue Exception => error
            return error
        end
    end
end