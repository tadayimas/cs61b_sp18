public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;	
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;	
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;	
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;		

	}

	public double calcDistance(Planet p) {
		double x = xxPos - p.xxPos;
		double y = yyPos - p.yyPos;
		double r = Math.pow(x * x + y * y, 0.5);
		return r;
	}

	public double calcForceExertedBy(Planet p) {
		//double r = this.calcDistance(p);
		double r = calcDistance(p);
		double F = G * mass * p.mass / r / r;
		return F;
	}

	public double calcForceExertedByX(Planet p) {
		double F = calcForceExertedBy(p);
		double r = calcDistance(p);
		double Fx = (p.xxPos - xxPos) / r * F;
		return Fx;
  	}

	public double calcForceExertedByY(Planet p) {
		double F = calcForceExertedBy(p);
		double r = calcDistance(p);
		double Fy = (p.yyPos - yyPos) / r * F;
		return Fy;
  	}



  	public double calcNetForceExertedByX(Planet[] Ps) {
  		double netFx = 0.0;
  		for(Planet p : Ps) {
  			if(this.equals(p)) continue;
  			netFx += calcForceExertedByX(p);
  		}
  		return netFx;
  	}

  	public double calcNetForceExertedByY(Planet[] Ps) {
  		double netFy = 0.0;
  		for(Planet p : Ps) {
  			if(this.equals(p)) continue;
  			netFy += calcForceExertedByY(p);
  		}
  		return netFy;
  	}

  	public void update(double dt, double fx, double fy) {
  		double ax = fx / mass;
  		double ay = fy / mass;
  		xxVel += ax * dt;
  		yyVel += ay * dt;
  		xxPos += xxVel * dt;
  		yyPos += yyVel * dt;
  	}

  	public void draw() {
  		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
  	}

}