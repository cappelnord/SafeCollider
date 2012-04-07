+ SimpleNumber {
	wait { // 3.5.1
		SafeCollider.assert(this != inf, "Can't wait for infinite time.");
		^this.yield;
	}	
}