package proyecto8;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] nombres = {"jose","Maria","Ana"};
		System.out.println(MisMatrices.getMenor(nombres));
	}

}

class MisMatrices{
	public static <T extends Comparable> T getMenor(T[]a) {
		if(a == null || a.length == 0) {
			return null;
		}
		
		T elementoMenor = a[0];
		for(int i = 1 ; i < a.length; i ++) {
			if(elementoMenor.compareTo(a[i])>0 ) {
				elementoMenor = a[i];
			}
		}
		return elementoMenor;
		
	}
}