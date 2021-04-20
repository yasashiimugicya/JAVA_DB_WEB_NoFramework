package chap06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {
	private DBConnection db;

	public ProductDAO(DBConnection db) {
		this.db = db;
	}

	public ArrayList<ProductDTO> findAll() throws Exception {
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "SELECT id, name, price FROM Products";

		Connection con = db.getConnect();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");

			ProductDTO dto = new ProductDTO(id, name, price);
			list.add(dto);
		}

		return list;
	}

	public ProductDTO find(String id) throws Exception {
		ProductDTO dto = null;
		String sql = "SELECT id, name, price FROM Products WHERE id = ?";

		Connection con = db.getConnect();

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, id);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			String productId = rs.getString("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");

			dto = new ProductDTO(productId, name, price);
		}

		return dto;
	}

	public boolean regist(ProductDTO dto) throws Exception {
		boolean judge = false;
		String sql = "INSERT INTO Products VALUES(?, ?, ?)";

		String id = dto.getId();
		String name = dto.getName();
		int price = dto.getPrice();

		Connection con = db.getConnect();

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, id);
		stmt.setString(2, name);
		stmt.setInt(3, price);

		int count = stmt.executeUpdate();

		if (count == 1) {
			judge = true;
		}

		return judge;
	}

	public boolean update(ProductDTO dto) throws Exception {
		boolean judge = false;
		String sql = "UPDATE Products SET price = ? WHERE id = ?";

		String id = dto.getId();
		int price = dto.getPrice();

		Connection con = db.getConnect();

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, price);
		stmt.setString(2, id);

		int count = stmt.executeUpdate();

		if (count == 1) {
			judge = true;
		}

		return judge;
	}

	public boolean delete(String id) throws Exception {
		boolean judge = false;
		String sql = "DELETE FROM Products WHERE id = ?";

		Connection con = db.getConnect();

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, id);

		int count = stmt.executeUpdate();

		if (count == 1) {
			judge = true;
		}

		return judge;
	}
}
