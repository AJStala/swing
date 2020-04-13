package com.eonsahead.swing;

/**
 * Model a Vector.
 *
 * @author Austin Stala
 * @version 4 April 2020
 */

import java.util.ArrayList;
import java.util.List;

public class Vector {

    private double[] elements = new double[4];

    public Vector() {
        for (int i = 0; i < 4; i++) {
            this.elements[i] = 0.0;
        } // for
    } // Vector()

    public Vector(double x, double y, double z) {
        this.elements[0] = x;
        this.elements[1] = y;
        this.elements[2] = z;
        this.elements[3] = 1.0;
    } // Vector( double, double, double )

    /**
     * Constructs a 4 element vector
     * @param x First element
     * @param y Second element
     * @param z Third element
     * @param h Fourth element
     */
    
    public Vector(double x, double y, double z, double h) {
        this.elements[0] = x;
        this.elements[1] = y;
        this.elements[2] = z;
        this.elements[3] = h;
    } // Vector( double, double, double, double )

    /**
     * returns the value at a specific point in the vector
     * @param index the specified point
     * @return the specified value
     */
    
    public double get( int index ) {
        return this.elements[index];
    } // get( int )
    
    /**
     * Changes the value at a specified point
     * @param index the point
     * @param value the value
     */
    
    public void set( int index, double value ) {
        this.elements[index] = value;
    } // set( int, double )
    
    /**
     * Sets all values of a vector to the same value
     * @param v the specified value
     */
    
    public void set( Vector v ) {
        this.elements[0] = v.elements[0];
        this.elements[1] = v.elements[1];
        this.elements[2] = v.elements[2];
        this.elements[3] = v.elements[3];
    } // set( Vector )
    
    /**
     * Adds the values of two vectors
     * @param v Second vector
     * @return The sum vector
     */
    
    public Vector add( Vector v ) {
        double x = this.get(0) + v.get(0);
        double y = this.get(1) + v.get(1);
        double z = this.get(2) + v.get(2);        
        return new Vector( x, y, z );
    } // add( Vector )
    
    
    /**
     * Subtract the values of two vectors
     * @param v Second vector
     * @return The difference vector 
     */
    
    public Vector subtract( Vector v ) {
        double x = this.get(0) - v.get(0);
        double y = this.get(1) - v.get(1);
        double z = this.get(2) - v.get(2);        
        return new Vector( x, y, z );
    } // subtract( Vector )
    
    public double dot( Vector v ) {
        double xProduct = this.get(0) * v.get(0);
        double yProduct = this.get(1) * v.get(1);
        double zProduct = this.get(2) * v.get(2);
        return xProduct + yProduct + zProduct;
    } // dot( Vector )
    
    public double magnitude() {
        return Math.sqrt( this.dot( this ) );
    } // magnitude()
    
    public Vector normalize() {
        double length = this.magnitude();
        double x = this.get(0) / length;
        double y = this.get(1) / length;
        double z = this.get(2) / length;
        return new Vector( x, y, z );
    } // normalize()
    
    public Vector cross( Vector v ) {
        double x = this.get(1) * v.get(2) - this.get(2) * v.get(1);
        double y = this.get(2) * v.get(0) - this.get(0) * v.get(2);
        double z = this.get(0) * v.get(1) - this.get(1) * v.get(0);
        return new Vector( x, y, z );
    } // cross( Vector )
    
    public static void main( String [] args ) {
        System.out.println( "hi");
        List<List<Vector>> surface = new ArrayList<>();
        
        List<Vector> poly0 = new ArrayList<>();
        poly0.add(new Vector());
        poly0.add(new Vector());
        
        List<Vector> poly1 = new ArrayList<>();
        poly1.add(new Vector());
        poly1.add(new Vector());
        
        surface.add( poly0 );
        surface.add( poly1 );
        
        System.out.println( "size = " + surface.size() );
    } // main( String [] )
} // Vector
