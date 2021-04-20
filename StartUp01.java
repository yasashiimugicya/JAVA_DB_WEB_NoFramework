package chap06;

import java.util.ArrayList;

public class StartUp01 {

	public static void main(String[] args) {
		DBConnection db = new DBConnection();

		try {
			ProductDAO dao = new ProductDAO(db);

			ArrayList<ProductDTO> list = dao.findAll();

			if (list.size() > 0) {
				for (ProductDTO dto : list) {
					String id = dto.getId();
					String name = dto.getName();
					int price = dto.getPrice();

					System.out.println(id + "\t" + name + "\t" + price);
				}
			} else {
				System.out.println("レコードがありません。");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
