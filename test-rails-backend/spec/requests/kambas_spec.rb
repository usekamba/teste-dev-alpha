RSpec.describe "/kambas", type: :request do
  let(:valid_attributes) {
    skip("Add a hash of attributes valid for your model")
  }

  let(:invalid_attributes) {
    skip("Add a hash of attributes invalid for your model")
  }

  let(:valid_headers) {
    {}
  }

  describe "GET /index" do
    it "renders a successful response" do
      Kamba.create! valid_attributes
      get kambas_url, headers: valid_headers, as: :json
      expect(response).to be_successful
    end
  end

  describe "GET /show" do
    it "renders a successful response" do
      kamba = Kamba.create! valid_attributes
      get kamba_url(kamba), as: :json
      expect(response).to be_successful
    end
  end

  describe "POST /create" do
    context "with valid parameters" do
      it "creates a new Kamba" do
        expect {
          post kambas_url,
               params: { kamba: valid_attributes }, headers: valid_headers, as: :json
        }.to change(Kamba, :count).by(1)
      end

      it "renders a JSON response with the new kamba" do
        post kambas_url,
             params: { kamba: valid_attributes }, headers: valid_headers, as: :json
        expect(response).to have_http_status(:created)
        expect(response.content_type).to match(a_string_including("application/json"))
      end
    end

    context "with invalid parameters" do
      it "does not create a new Kamba" do
        expect {
          post kambas_url,
               params: { kamba: invalid_attributes }, as: :json
        }.to change(Kamba, :count).by(0)
      end

      it "renders a JSON response with errors for the new kamba" do
        post kambas_url,
             params: { kamba: invalid_attributes }, headers: valid_headers, as: :json
        expect(response).to have_http_status(:unprocessable_entity)
        expect(response.content_type).to eq("application/json")
      end
    end
  end

  describe "PATCH /update" do
    context "with valid parameters" do
      let(:new_attributes) {
        skip("Add a hash of attributes valid for your model")
      }

      it "updates the requested kamba" do
        kamba = Kamba.create! valid_attributes
        patch kamba_url(kamba),
              params: { kamba: invalid_attributes }, headers: valid_headers, as: :json
        kamba.reload
        skip("Add assertions for updated state")
      end

      it "renders a JSON response with the kamba" do
        kamba = Kamba.create! valid_attributes
        patch kamba_url(kamba),
              params: { kamba: invalid_attributes }, headers: valid_headers, as: :json
        expect(response).to have_http_status(:ok)
        expect(response.content_type).to eq("application/json")
      end
    end

    context "with invalid parameters" do
      it "renders a JSON response with errors for the kamba" do
        kamba = Kamba.create! valid_attributes
        patch kamba_url(kamba),
              params: { kamba: invalid_attributes }, headers: valid_headers, as: :json
        expect(response).to have_http_status(:unprocessable_entity)
        expect(response.content_type).to eq("application/json")
      end
    end
  end

  describe "DELETE /destroy" do
    it "destroys the requested kamba" do
      kamba = Kamba.create! valid_attributes
      expect {
        delete kamba_url(kamba), headers: valid_headers, as: :json
      }.to change(Kamba, :count).by(-1)
    end
  end
end
