class CreateActivities < ActiveRecord::Migration[5.1]
  def change
    create_table :activities do |t|

      t.timestamps
    end
  end
end
