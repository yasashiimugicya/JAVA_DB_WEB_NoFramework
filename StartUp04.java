package chap06;

public class StartUp04 {

	public static void main(String[] args) {
		DBConnection db = new DBConnection();

		try {
			ProductDAO dao = new ProductDAO(db);

			ProductDTO dto = new ProductDTO("0104", null, 600);

			boolean judge = dao.update(dto);

			if (judge == true) {
				System.out.println("正常に変更できました。");
			} else {
				System.out.println("変更に失敗しました。");
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
