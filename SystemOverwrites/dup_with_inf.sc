+ Function {
	dup { arg n = 2; // 3.5.1
		var array;
		(n == inf).if {"SafeCollider: Can't dup inf times".error;^nil;};
		array = Array(n);
		n.do {|i| array.add(this.value(i)) };
		^array
	}
}

+ Object {
	dup { arg n = 2; // 3.5.1
		(n == inf).if {"SafeColider: Can't dup inf times".error;^nil;};
		^Array.fill(n, { this.copy });
	}	
}