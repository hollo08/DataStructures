package linkedIn;

public class TextJustification {

	public static void main(String[] args) {
		String[] text = { "This", "is", "an", "example", "of", "text", "justification."};
		int justify = 16;
		for (int i = 0; i < text.length; i++) {
			int temp = justify;
			int j = i;
			while (temp > 0 && i < text.length) {
				temp -= text[i++].length();
			}
			i--;
			int num_words = i - j + 1;
			while (temp < num_words-1) {
				temp += text[i].length();
				i--;
				num_words--;
			}
			if(num_words == 1){
				num_words++;
			}
			int extra = (temp) % (num_words-1);
			int spaces = (temp) / (num_words-1);
			for (int k = j; k <=i; k++) {
				System.out.print(text[k]);
				if(k!=i)
				for (int l = 0; l < spaces; l++)
					System.out.print(" ");
				if (k == j)
					for (int l = 0; l < extra; l++)
						System.out.print(" ");
			}
			System.out.println();
		}
	}

}
