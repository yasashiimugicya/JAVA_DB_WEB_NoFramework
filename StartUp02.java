package chap06;

public class StartUp02 {

	public static void main(String[] args) {
		DBConnection db = new DBConnection();

		try {
			ProductDAO dao = new ProductDAO(db);

			ProductDTO dto = dao.find("0102");

			if (dto != null) {
				String id = dto.getId();
				String name = dto.getName();
				int price = dto.getPrice();

				System.out.println(id + "\t" + name + "\t" + price);
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
