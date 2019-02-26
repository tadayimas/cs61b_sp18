public class NBody {
	public static double readRadius(String filename) {
		In in = new In(filename);

		int num = in.readInt();
		double radius = in.readDouble();
		return radius;

	}

	public static Planet[] readPlanets(String filename) {
		In in = new In(filename);

		int num = in.readInt();
		double radius = in.readDouble();

		Planet[] ps = new Planet[num];
		for(int i = 0; i < num; i++) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();	
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			ps[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return ps;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		
		double radius = readRadius(filename);
		Planet[] ps = readPlanets(filename);

		// String background = "images/starfield.jpg";
		// StdDraw.setScale(-radius, radius);
		// StdDraw.clear();
		// StdDraw.picture(0, 0, background);
		// StdDraw.show();

		// for(Planet p : ps) {
		// 	p.draw();
		// }

		/* Creating an Animation */
		
		double t = 0.0;
		int num = ps.length;
		double[] xForces = new double[num];
		double[] yForces = new double[num];
		String background = "images/starfield.jpg";
		while(t <= T) {
			for(int i = 0; i < num; i++) {
				xForces[i] = ps[i].calcNetForceExertedByX(ps);
				yForces[i] = ps[i].calcNetForceExertedByY(ps);
			}
			for(int i = 0; i < num; i++) {
				ps[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.enableDoubleBuffering();
			StdDraw.setScale(-radius, radius);
			StdDraw.clear();
			StdDraw.picture(0, 0, background);
			
			for(Planet p : ps) {
				p.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);

			t += dt;

		}

		StdOut.printf("%d\n", ps.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < ps.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", ps[i].xxPos, ps[i].yyPos, ps[i].xxVel, ps[i].yyVel, ps[i].mass, ps[i].imgFileName);   
    	}

	}















}