+ SimpleNumber {
	wait { // 3.5.1
		(this == inf).if {"SafeCollider: Can't wait for a infinite time.".error;^nil};
		^this.yield;
	}	
}