import java.util.Random;

//a = 4 x 3  matrix. It means a has 4 row and 3 columns. There are 12 = 3 x 4 numbers (elements)
//within the matrix A   a[4][3]

//Matrix is often used for graphics, solving equations.
//5 * x + 3 * y + 2 * z = 20
//x + y - z = 5
//2 * x - y + z = 30
//To solve this equation, you have to eliminate x, y, or z step by step  
//For programming, it is hard to perform the elimination operation. Instead,
//it uses matrix product format. 
//The coefficients:
//[5  3  2
//1  1  -1   = A   (3x3)
//2 -1  1]

//[ x
//y  = B  (3x1)
//z]

//[20
//5   = C (3x1)
//30]

//Matrix product:   A * B = C
//For one element (x, y) of C, which means the number at the x-th column and y-th row in C
//C[y][x] = The y-th row of matrix A * the x-th column of matrix B


/*This class implements the Java Runnable interface that will calculate col_idx-th column of the result matrix */
class ColumnCalculator implements Runnable{
	
	Matrix m1;
	Matrix m2;
	Matrix result;
	int col_idx; //specify which column of the result is going to be calculated

	ColumnCalculator(Matrix m_1, Matrix m_2, Matrix r, int col)
	{
		m1 = m_1;
		m2 = m_2;
		result = r;
		col_idx = col;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
                for (int i = 0; i < m2.values[0].length; i++) {
                    result.values[col_idx][i] = 0;
                
                for (int j = 0; j < m1.values[col_idx].length; j++) {
                    result.values[col_idx][i] += m1.values[col_idx][j] * m2.values[j][i];    
		//calculating all the elements in the column of index (specified by "col_idx") of the result matrix
	
                }        }}
	
}

public class Matrix {
	int rows; // Define the number of rows
	int cols; // Define the number of columns
	double values[][];
	
	Random rand = new Random();

	/*First constructor: with row and column as the input that creates a matrix with the specified size and 
	 * assign each elements with randomly generated number*/
	Matrix(int r, int c) {
		rows = r;
		cols = c;
		values = new double[r][c];
		
		for(int y = 0; y < rows; y++)
		{
			for(int x = 0; x < cols; x++)
			{
				values[y][x] = rand.nextDouble() * 10.0; //generating a double number between 0 and 10
			}
		}

	}

	/*First constructor: with row, column, and a 2D array as the input. Similar to the first constructor
	 * above, but instead of randomly generating, it assigns the elements with the third argument double 2D array.  */
	Matrix(int r, int c, double v[][]) {
                rows = r;
                cols = c;
                values = new double[r][c];


            if (rows*cols <= v.length){ // if the two arrays are same size of v is greater
		for(int y = 0; y < rows; y++)
		{
			for(int x = 0; x < cols; x++) //array copy
			{
                            
				values[y][x] = v[y][x]; //putting array v elements into values array
			}
		}}
            else{ // if array v is shorter than array values
		for(int y = 0; y < rows; y++) 
		{
			for(int x = 0; x < cols; x++)
			{
                            if (v[y][x] == 0){ //if array v is empty
                                values[y][x] = 0;
                            }
                            values[y][x] = v[y][x]; //putting array v elements into values array
			}
		}                  
                        }
	}
	
	
	/*Output the matrix to the console*/
	void print()
	{
		for(int y = 0; y < rows; y++)
		{
			for(int x = 0; x < cols; x++)
			{
				System.out.print(values[y][x] + ", ");
			}
			System.out.println();
		}	
	}
	
	
	/*Matrix product without thread: let the current matrix times the input argument matrix m
	 * and return the result matrix
	 * Below the multiplication is already provided but you need to add a few lines of code to 
	 * do the dimension check. If the input matrix does not satisfy the dimension requirement for
	 * matrix product, you can print out a message and return a null matrix*/
	Matrix multiplyBy(Matrix m)
	{
		Matrix result = new Matrix(rows, m.cols); //Initialize the result matrix
                
		if (cols != m.rows){
                    System.out.println("Can not multiply matrices.");
                    result = null;
                }
		

                else{
		for(int y = 0; y < result.rows; y++)
		{
			for(int x = 0; x < result.cols; x++)
			{
				result.values[y][x] = 0; //the yth row of current matrix x the xth column of m
				for(int i = 0; i < cols; i++)
				{
					result.values[y][x] += values[y][i] * m.values[i][x];
				}
				
				
//				A        *         B         = result
//			   [5, 3            [1, 2, 3        [? ? (y = 0, x = 1) ?
//				2, 0]			 4, 5, 6]        ? ?                ?]
						
				
			}
		}	
                }
		return result;
	}
	
	
	/*Implementation: instead using loops above to calculate each elements, 
	 * here you will use threads to accomplish the matrix product task.
	 * Similar to the "multiplyBy()" above, the input matrix m represents
	 * the second matrix that you will use the current matrix to times. The
	 * returned Matrix will be the product result matrix.  
	 * The code below is just an example, which is not the real solution. 
	 * You need to create multiple threads to do the multiplication with each thread
	 * computing one column within the result matrix*/
	Matrix multiplyByThreads(Matrix m)
	{
            if (cols!= m.rows){
                System.out.println("Can not multiply matrices.");
                Matrix result = null;
                return result;
            }
            
            Matrix result = new Matrix(rows, m.cols);
            
            //create threads
            int colcount = 0; int threadcount = 0;
            Thread thread1 = null;
            Thread thread2 = null;
            Thread thread3 = null;
            Thread thread4 = null;
            Thread thread5 = null;
            Thread thread6 = null;
            Thread thread7 = null;
            Thread thread8 = null;
            Thread thread9 = null;
            Thread thread10 = null;
            
            while (colcount < m.cols){ //threads
                try{
                    if (threadcount == 0){
                        thread1 = new Thread(new ColumnCalculator(this, m, result, colcount));
                        colcount++;
                        threadcount++;
                        thread1.start();
                    }
                    else if (threadcount == 1) {
                        thread2 = new Thread(new ColumnCalculator(this, m, result, colcount));
                        colcount++;
                        threadcount++;
                        thread2.start();
                    }
                    else if (threadcount == 2) {
                        thread3 = new Thread(new ColumnCalculator(this, m, result, colcount));
                        colcount++;
                        threadcount++;
                        thread3.start();
                    }
                    else if (threadcount == 3) {
                        thread4 = new Thread(new ColumnCalculator(this, m, result, colcount));
                        colcount++;
                        threadcount++;
                        thread4.start();
                    }
                    else if (threadcount == 4) {
                        thread5 = new Thread(new ColumnCalculator(this, m, result, colcount));
                        colcount++;
                        threadcount++;
                        thread5.start();
                    }
                    else if (threadcount == 5) {
                        thread6 = new Thread(new ColumnCalculator(this, m, result, colcount));
                        colcount++;
                        threadcount++;
                        thread6.start();
                    }
                    else if (threadcount == 6) {
                        thread7 = new Thread(new ColumnCalculator(this, m, result, colcount));
                        colcount++;
                        threadcount++;
                        thread7.start();
                    }
                    else if (threadcount == 7) {
                        thread8 = new Thread(new ColumnCalculator(this, m, result, colcount));
                        colcount++;
                        threadcount++;
                        thread8.start();
                    }
                    else if (threadcount == 8) {
                        thread9 = new Thread(new ColumnCalculator(this, m, result, colcount));
                        colcount++;
                        threadcount++;
                        thread9.start();
                    }
                    else if (threadcount == 9) {
                        thread10 = new Thread(new ColumnCalculator(this, m, result, colcount));
                        colcount++;
                        threadcount++;
                        thread10.start();
                    }
                    else {
                        thread1.join();
                        thread2.join();
                        thread3.join();
                        thread4.join();
                        thread5.join();
                        thread6.join();
                        thread7.join();
                        thread8.join();
                        thread9.join();
                        thread10.join();
                        threadcount = 0;
                    }
                
                } catch (InterruptedException ie){
                    System.out.println(ie);
                }
            }
            
            
            return result; 

	}
	
	
	/* The main function for evaluation purpose*/
	public static void main(String[] args)
	{
             double [][] matrix1 = { { 1, 2, 1 }, { 4, 7, 5 }, { 6, 9, 2 } };
             double [][] matrix2 = { { 3, 2, 4 }, { 4, 1, 8 }, { 2, 1, 2 } };
		Matrix m1 = new Matrix(3, 3, matrix1);

		Matrix m2 = new Matrix(3, 3, matrix2);
                
                Matrix r1 = m1.multiplyByThreads(m2); //threads test
                
                System.out.println("Problem 1");
                r1.print();

                Matrix m3 = new Matrix(1000, 2000); //test 2
                
                Matrix m4 = new Matrix(2000, 1000);
                
                Matrix r2 = m3.multiplyByThreads(m4);

		Matrix r3 = m3.multiplyBy(m4);
                
                System.out.print("By Threads");
                r2.print();
                System.out.print("By Loops");
                r3.print();
		
	}
}