package main;

public class Matrix {
    //dimensions of matrix
    private int dimrow, dimcol;
    public double matrix[][];

    //constructor
    public Matrix(int row, int col) throws Exception {
        if(row<0 || col<0)
            throw new Exception("Invalid dimentions");
        else {
            this.dimrow = row;
            this.dimcol = col;
            matrix=new double[dimrow][dimcol];
        }
    }

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
        if(row<0 || col<0 || dimrow<=row || dimcol<=col) {
            throw new Exception("Matrix out of entry");
        }else
            matrix[row][col] = value;
    }

    //method to get value of entry
    public double getEntry(int row, int col) throws Exception {
        if(row<0 || col<0 || row>=dimrow || col>=dimcol)
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

    //matrix transposition already tested
    public void transpose(Matrix m) throws Exception {
        if(dimcol!=m.getDimrow() || dimrow!=m.getDimcol()){
            throw new Exception("Wrong dimentions");
        }
        for(int i=0 ; i<dimrow ;i++){
            for(int j=0; j<dimcol; j++){
                matrix[i][j]=m.getEntry(j,i);
            }
        }

    }

    //column getter of matrix already tested
    public void getCol(int n, Matrix m) throws Exception {
        if(n<0 || n>=m.getDimcol() || dimcol>1){
            throw new Exception("No column exist");
        }else {
            for(int i=0 ;i<m.getDimrow(); i++){
                matrix[i][0]=m.getEntry(i,n);
            }
        }
    }
}
