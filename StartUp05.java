package chap06;

public class StartUp05 {

	public static void main(String[] args) {
		DBConnection db = new DBConnection();

		try {
			ProductDAO dao = new ProductDAO(db);

			boolean judge = dao.delete("0104");

			if (judge == true) {
				System.out.println("正常に削除できました。");
			} else {
				System.out.println("削除に失敗しました。");
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
