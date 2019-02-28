package main;



public class Matrix {
    //dimensions of matrix
    private int dimrow, dimcol;

    //constructor
    public Matrix(int dimrow, int dimcol) throws Exception {
        if(dimrow<0 || dimcol<0)
            throw new Exception("Invalid dimentions");
        else {
            this.dimrow = dimrow;
            this.dimcol = dimcol;
        }

    }
    //creation of matrix
    public double matrix[][]=new double[dimrow][dimcol];
    //change of dimensions
    public void setDimensions(int dimrow, int dimcol) throws Exception {
        if(dimrow<0 || dimcol<0 || dimrow>=this.dimrow || dimcol>=this.dimcol)
            throw new Exception("Invalid dimentions");
        else {
            this.dimrow = dimrow;
            this.dimcol = dimcol;
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
        if(dimrow<0 || dimcol<0 || dimrow>=this.dimrow || dimcol>=this.dimcol)
            throw new Exception("Matrix out of entry");
        else
            matrix[row][col] = value;
    }

    //method to get value of entry
    public double getEntry(int row, int col) throws Exception {
        if(dimrow<0 || dimcol<0 || dimrow>=this.dimrow || dimcol>=this.dimcol)
            throw new Exception("Matrix out of entry");
        else
            return matrix[row][col];

    }

    //definition of inner product
    private double innerproduct(Matrix A, Matrix B) throws Exception {
        if(A.getDimcol()!=1 || B.getDimcol()!=1 || A.getDimrow()!=B.getDimrow()){
            throw new Exception("Invalid matrices dimensions");
        }else{
            double a=0;
            for(int i=0; i<A.getDimrow(); i++){
                a+=(A.getEntry(i, 0)*B.getEntry(i,0));
            }
            return a;
        }
    }

    //matrix transposition
    public void transpose() throws Exception {
        double T[][]=new double[dimcol][dimrow];
        for(int i=0 ; i<dimrow ;i++){
            for(int j=0; j<dimcol; j++){
                T[i][j]=matrix[j][i];
            }
            int x=dimcol;
            dimcol=dimrow;
            dimrow=x;
            matrix=T;
        }
    }

    //column getter of matrix
    private Matrix getCol(int n) throws Exception {
        if(n<0 || n>=dimcol){
            throw new Exception("No column exist");
        }else {
            Matrix Col = new Matrix(dimrow, 1);
            for (int i = 0; i < dimrow; i++) {
                Col.setEntry(i, 0, matrix[i][n]);
            }
            return Col;
        }
    }
    
}
