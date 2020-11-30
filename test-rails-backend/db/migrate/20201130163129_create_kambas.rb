class CreateKambas < ActiveRecord::Migration[6.0]
  def change
    create_table :kambas do |t|

      t.timestamps
    end
  end
end
