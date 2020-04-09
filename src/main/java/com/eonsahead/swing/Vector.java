
package com.eonsahead.swing;


public class Vector {

    private double x;
    private double y;
    private double z;
    private double w;
    
    
    public Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }
    
    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 1;
    } // Vector(double x, double y, double z)
    
    public Vector(double x, double y, double z, double w){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    
    public double get(int position){
        switch(position) {
            case 0:
                return this.x;
            case 1:
                return this.y;
            case 3:
                return this.z;  
        }
        return this.w;
    }
    
    public void set(int position, double value) {
        switch(position){
            case 0:
                this.x = value;
            case 1:
                this.y = value;
            case 2:
                this.z = value;
            case 3:
                this.w = value;
        }
    }
    
    public Vector add(Vector v) {
        double sumX = this.x + v.x;
        double sumY = this.y + v.y;
        double sumZ = this.z + v.z;
        return new Vector(sumX, sumY, sumZ);
    }
    
    public Vector subtract(Vector v) {
        double subX = this.x - v.x;
        double subY = this.y - v.y;
        double subZ = this.z - v.z;
        return new Vector(subX, subY, subZ);
    }
    
    public double dot(Vector v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }
    
    public double magnitude(){
        return Math.sqrt(this.dot(this));
    }
    
    public Vector normalize(){
        double mag = this.magnitude();
        Vector newVec = new Vector();
        for(int i = 0; i < 3; i++) {
            double newVal = this.get(i) / mag;
            newVec.set(i, newVal);
        }
        newVec.set(3,1);
        return newVec;
    }
    
    public Vector cross(Vector v) {
        double newX = this.y * v.z - this.z * v.y;
        double newY = this.z * v.x - this.x * v.z;
        double newZ = this.x * v.y - this.y * v.x;
        return new Vector(newX, newY, newZ);
    }
    
    @Override
    public String toString() {

      return "(" + this.x + ", " + this.y + ", " 
                + this.z + ", " + this.w + ")";

    }  
    
} // Vector
