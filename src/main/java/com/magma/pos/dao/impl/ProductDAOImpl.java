package com.magma.pos.dao.impl;

import com.magma.pos.config.DatabaseConfig;
import com.magma.pos.dao.ProductDAO;
import com.magma.pos.entities.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public Product findById(int id) {

        String sql = "SELECT * FROM product WHERE id = ?";

        try (
                Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                return new Product(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getDouble("price"),
                        result.getInt("quantity")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Product> findAll() {

        List<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM product";

        try (
                Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet result = statement.executeQuery()
        ) {

            while (result.next()) {

                Product product = new Product(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getDouble("price"),
                        result.getInt("quantity")
                );

                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public boolean save(Product product) {

        String sql =
                "INSERT INTO product (name, price, quantity) VALUES (?, ?, ?)";

        try (
                Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Product product) {

        String sql =
                "UPDATE product SET name = ?, price = ?, quantity = ? WHERE id = ?";

        try (
                Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setInt(4, product.getId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {

        String sql = "DELETE FROM product WHERE id = ?";

        try (
                Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}