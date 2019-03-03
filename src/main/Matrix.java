package main;


public class Matrix {
    //dimensions of matrix
    private int dimrow, dimcol;
    public double matrix[][];

    //constructor
    public Matrix(int row, int col) throws Exception {
        if (row < 0 || col < 0)
            throw new Exception("Invalid dimentions");
        else {
            this.dimrow = row;
            this.dimcol = col;
            matrix = new double[dimrow][dimcol];
        }
    }

    //getters of dimensions
    public int getDimrow() {
        return dimrow;
    }

    public int getDimcol() {
        return dimcol;
    }

    //method to set values od entries
    public void setEntry(int row, int col, double value) throws Exception {
        if (row < 0 || col < 0 || dimrow <= row || dimcol <= col) {
            throw new Exception("Matrix out of entry");
        } else
            matrix[row][col] = value;
    }

    //method to get value of entry
    public double getEntry(int row, int col) throws Exception {
        if (row < 0 || col < 0 || row >= dimrow || col >= dimcol)
            throw new Exception("Matrix out of entry");
        else
            return matrix[row][col];
    }

    //definition of inner product
    private double innerproduct(Matrix B) throws Exception {
        if (dimcol != 1 || B.getDimcol() != 1 || dimrow != B.getDimrow()) {
            throw new Exception("Invalid matrices dimensions");
        } else {
            double a = 0;
            for (int i = 0; i < dimrow; i++) {
                a += (matrix[i][0] * B.getEntry(i, 0));
            }
            return a;
        }
    }

    //matrix transposition
    public void transpose(Matrix m) throws Exception {
        if (dimcol != m.getDimrow() || dimrow != m.getDimcol()) {
            throw new Exception("Wrong dimentions");
        }
        for (int i = 0; i < dimrow; i++) {
            for (int j = 0; j < dimcol; j++) {
                matrix[i][j] = m.getEntry(j, i);
            }
        }

    }

    //column getter of matrix already tested
    private void getCol(int n, Matrix m) throws Exception {
        if (n < 0 || n >= m.getDimcol() || dimcol > 1) {
            throw new Exception("No column exist");
        } else {
            for (int i = 0; i < m.getDimrow(); i++) {
                matrix[i][0] = m.getEntry(i, n);
            }
        }
    }

    //product of two matrices
    public void product(Matrix A, Matrix B) throws Exception {
        if (A.getDimcol() != B.getDimrow() || dimcol != B.getDimcol() || dimrow != A.getDimrow()) {
            throw new Exception("Wrong dimensions");
        }
        Matrix a = new Matrix(A.getDimcol(), 1);
        Matrix b = new Matrix(B.getDimrow(), 1);
        Matrix AT = new Matrix(A.getDimcol(), A.getDimrow());
        AT.transpose(A);
        for (int i = 0; i < dimrow; i++) {
            a.getCol(i, AT);
            for (int j = 0; j < dimcol; j++) {
                b.getCol(j, B);
                matrix[i][j] = a.innerproduct(b);
            }
        }
    }

    public double determinant() throws Exception{
        if (dimcol != dimrow) {
            throw new Exception("Square matrix expected");
        } else {
            if (dimcol == 1) {
                return matrix[0][0];
            }else{
                Matrix minor=new Matrix(dimrow-1, dimcol-1);
                double det=0;
                for(int i=0; i<dimcol; i++) {
                    for (int k = 0; k < i; k++) {
                        for (int j = 1; j <dimrow; j++) {
                            minor.setEntry(j-1,k, matrix[j][k]);
                        }
                    }
                    for (int k = i+1; k < dimcol; k++) {
                        for (int j = 1; j <dimrow; j++) {
                            minor.setEntry(j-1,k-1, matrix[j][k]);
                        }
                    }
                    det = det + (Math.pow(-1, Double.valueOf(i+""))*matrix[0][i] * minor.determinant());
                }
                return det;
            }
        }

    }

}

