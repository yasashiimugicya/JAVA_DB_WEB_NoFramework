package chap06;

public class StartUp03 {

	public static void main(String[] args) {
		DBConnection db = new DBConnection();

		try {
			ProductDAO dao = new ProductDAO(db);

			ProductDTO dto = new ProductDTO("0104", "ぶどう", 550);

			boolean judge = dao.regist(dto);

			if (judge == true) {
				System.out.println("正常に登録できました。");
			} else {
				System.out.println("登録に失敗しました。");
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
