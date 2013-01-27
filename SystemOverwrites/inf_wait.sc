+ SimpleNumber {
	wait { // 3.5.1, 3.6.2
		SafeCollider.assert(this != inf, "Can't wait for infinite time.");
		^this.yield;
	}	
}