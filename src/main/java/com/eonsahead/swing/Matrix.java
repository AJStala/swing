package com.eonsahead.swing;

/**
 * Model a matrix.
 *
 * @author Leon Tabak
 * @version 1 April 2020
 */
public class Matrix {

    double[][] elements = new double [4] [4];

    public Matrix() {
        this.identity();
    } // Matrix()

    public double get(int row, int column) {
        return this.elements[row][column];
    } // get( int, int )

    public void set(int row, int column, double value) {
        this.elements[row][column] = value;
    } // set( int, int, double )

    public final void identity() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    this.set(i, j, 1.0);
                } // if
                else {
                    this.set(i, j, 0.0);
                } // else
            } // for
        } // for
    } // identity()

    public void rotationZ(double angle) {
        this.identity();
        this.set(0, 0, Math.cos(angle));
        this.set(0, 1, -Math.sin(angle));
        this.set(1, 0, Math.sin(angle));
        this.set(1, 1, Math.cos(angle));
    } // rotationZ( double )
    
    public void rotationX(double angle) {
        this.identity();
        this.set(1, 1, Math.cos(angle));
        this.set(1, 2, -Math.sin(angle));
        this.set(2, 1, Math.sin(angle));
        this.set(2, 2, Math.cos(angle));
    } // rotationX( double )
    
    public void rotationY(double angle) {
        this.identity();
        this.set(0, 0, Math.cos(angle));
        this.set(2, 1, -Math.sin(angle));
        this.set(2, 0, Math.sin(angle));
        this.set(2, 2, Math.cos(angle));
    } // rotationY( double )
    
    public final void scale(double x, double y, double z) {
        this.identity();
        this.set(0, 0, x);
        this.set(1, 1, y);
        this.set(2, 2, z);
    }

    public Matrix multiply(Matrix otherMatrix) {
        Matrix product = new Matrix();
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                double sum = 0.0;
                for (int k = 0; k < 4; k++) {
                    sum += this.elements[row][k]
                            * otherMatrix.elements[k][column];
                } // for
                product.set(row, column, sum);
            } // for
        } // for
        return product;
    } // multiply( Matrix )

    private String rowToString(int row) {
        StringBuilder result = new StringBuilder();
        result.append("( ");
        for (int i = 0; i < 3; i++) {
            result.append(this.get( row, i));
            result.append(",");
        } // for
        result.append(this.get( row, 3 ));
        result.append(" )");
        return result.toString();
    } // rowToString( int )
    
    public Vector multiply(Vector v) {
        Vector newVec = new Vector();
        for(int i = 0; i < 4; i++) {
            double sum = 0;
            for(int j = 0; j < 4; j++) {
                sum = sum + this.elements[i][j] * v.get(j);
            }
            newVec.set(i, sum);
        }
        return newVec;
    }
    
    public final void translate(double x, double y, double z) {
        this.identity();
        this.set(0, 3, x);
        this.set(1, 3, y);
        this.set(2, 3, z);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[ ");
        for (int i = 0; i < 4; i++) {
            result.append('\t' + rowToString(i) + '\n');
        } //
        result.append(" ]");
        return result.toString();
    } // toString()

    public static void main(String[] args) {
        Matrix identity = new Matrix();
        System.out.println("identity = \n " + identity);

        Matrix product = identity.multiply(identity);
        System.out.println("product = \n " + product);

        Matrix ccw = new Matrix();
        ccw.rotationZ(Math.PI / 4);
        System.out.println("counter-clockwise rotation = \n " + ccw);

        Matrix cw = new Matrix();
        cw.rotationZ(-Math.PI / 4);
        System.out.println("clockwise rotation = \n " + cw);

        Matrix netRotation = ccw.multiply(cw);
        System.out.println("net rotation = \n " + netRotation);
    } // main( String [] )

} // Matrix
