require 'net/https'
require 'uri'
require 'json'

class Kamba < ApplicationRecord
    def self.solicitar
        uri = URI.parse("https://kamba-api-staging.herokuapp.com")
        http = Net::HTTP.new(uri.host, uri.port)
        http.use_ssl = true
        http.verify_mode = OpenSSL::SSL::VERIFY_NONE
        request = Net::HTTP::Get.new("/v1/users/activities", {'Content-Type' =>'application/json',  'Authorization' => 'Token ySJr21cFmVWMM7D33xRQAAtt'})
        answer = http.request(request).body
        JSON.parse (answer)
    end
end
