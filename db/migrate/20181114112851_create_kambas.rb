class CreateKambas < ActiveRecord::Migration[5.1]
  def change
    create_table :kambas do |t|

      t.timestamps
    end
  end
end
