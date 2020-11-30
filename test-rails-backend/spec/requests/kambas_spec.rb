RSpec.describe "/kambas", type: :request do
  describe "GET /index" do
    it "renders a successful response" do
      get api_v1_kambas_url, as: :json
      expect(response).to be_successful
    end
  end
end
