class ActivitiesController < ApplicationController
  #before_action :set_activity, only: [:show, :edit, :update, :destroy]

  # GET /activities
  # GET /activities.json
  def index
    @activities = Activity.all_activities
    render json: @activities
  end

end
