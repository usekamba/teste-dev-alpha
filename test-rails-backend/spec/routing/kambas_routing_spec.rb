RSpec.describe KambasController, type: :routing do
  describe "routing" do
    it "routes to #index" do
      expect(get: "/kambas").to route_to("kambas#index")
    end

    it "routes to #show" do
      expect(get: "/kambas/1").to route_to("kambas#show", id: "1")
    end


    it "routes to #create" do
      expect(post: "/kambas").to route_to("kambas#create")
    end

    it "routes to #update via PUT" do
      expect(put: "/kambas/1").to route_to("kambas#update", id: "1")
    end

    it "routes to #update via PATCH" do
      expect(patch: "/kambas/1").to route_to("kambas#update", id: "1")
    end

    it "routes to #destroy" do
      expect(delete: "/kambas/1").to route_to("kambas#destroy", id: "1")
    end
  end
end
