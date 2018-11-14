class KambaController < ApplicationController
    
 

    def index
        @payment = Array.new
        @withdrawal = Array.new
        filter(Kamba.solicitar)
    end

    private
        def filter(json)
            json.each do |p|
                if p["transaction_type"] == "PAYMENT"
                    @payment << p
                elsif
                    @withdrawal << p                    
                end
            end            
        end
end
