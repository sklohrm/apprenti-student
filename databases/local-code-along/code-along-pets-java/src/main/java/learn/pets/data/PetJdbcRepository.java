package learn.pets.data;

import com.mysql.cj.jdbc.MysqlDataSource;
import learn.pets.models.Pet;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetJdbcRepository implements PetRepository {

    private DataSource dataSource = initDataSource();

    private DataSource initDataSource() {
        MysqlDataSource result = new MysqlDataSource();
        result.setURL("jdbc:mysql://localhost:3306/pets?serverTimezone=America/Chicago");
        result.setUser("root");
        result.setPassword("");
        return result;
    }

    @Override
    public List<Pet> findAll() {
        ArrayList<Pet> result = new ArrayList<>();
        final String sql = "SELECT pet_id, `name`, `type` FROM pet;";

        try(Connection conn = dataSource.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql))
        {
            while (rs.next()) {
                Pet pet = new Pet();
                pet.setPetId(rs.getInt("pet_id"));
                pet.setName(rs.getString("name"));
                pet.setType(rs.getString("type"));
                result.add(pet);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }

    @Override
    public Pet findByName(String petName) {
        String sql = "SELECT pet_id, `name`, `type` FROM pet WHERE name = ?;";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql))
        {
            statement.setString(1, petName);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Pet pet = new Pet();
                    pet.setPetId(rs.getInt("pet_id"));
                    pet.setName(rs.getString("name"));
                    pet.setType(rs.getString("type"));
                    return pet;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Pet findById(int petId) {
        String sql = "SELECT pet_id, `name`, `type` FROM pet WHERE pet_id = ?;";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql))
        {
            statement.setInt(1, petId);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Pet pet = new Pet();
                    pet.setPetId(rs.getInt("pet_id"));
                    pet.setName(rs.getString("name"));
                    pet.setType(rs.getString("type"));
                    return pet;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Pet add(Pet pet) {
        final String sql = "INSERT INTO pet (`name`, `type`) VALUES (?,?)";
        try (Connection conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS))
        {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getType());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted <= 0) {
                return null;
            }
            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    pet.setPetId(keys.getInt(1));
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return pet;
    }

    @Override
    public boolean update(Pet pet) {
        final String sql = "UPDATE pet SET `name` = ?, `type` = ? WHERE pet_id = ?;";
        try (Connection conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql))
        {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getType());
            statement.setInt(3, pet.getPetId());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean deleteById(int petId) {
        final String sql = "DELETE FROM pet WHERE pet_id = ?";
        try (Connection conn = dataSource.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql))
        {
            statement.setInt(1, petId);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }
}
