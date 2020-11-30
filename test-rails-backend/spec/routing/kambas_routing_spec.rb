RSpec.describe Api::V1::KambasController, type: :routing do
  describe "routing" do
    it "routes to #index" do
      expect(get: "/api/v1/kambas").to route_to({"format" => :json, "controller" => "api/v1/kambas", "action" => "index"})
    end
  end
end
