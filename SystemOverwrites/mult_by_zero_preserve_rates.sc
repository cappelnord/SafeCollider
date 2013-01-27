// removes multiply optimization which
// can lead to faulty rates

+ BinaryOpUGen { // 3.6.2
	*new1 { arg rate, selector, a, b;

		// eliminate degenerate cases
		if (selector == '*', {
			if (a == 0.0, { ^DC.multiNew(rate, 0) });
			if (b == 0.0, { ^DC.multiNew(rate, 0) });
			if (a == 1.0, { ^b });
			if (a == -1.0, { ^b.neg });
			if (b == 1.0, { ^a });
			if (b == -1.0, { ^a.neg });
		},{
		if (selector == '+', {
			if (a == 0.0, { ^b });
			if (b == 0.0, { ^a });
		},{
		if (selector == '-', {
			if (a == 0.0, { ^b.neg });
			if (b == 0.0, { ^a });
		},{
		if (selector == '/', {
			if (b == 1.0, { ^a });
			if (b == -1.0, { ^a.neg });
			if (b.rate == 'scalar', { ^a * b.reciprocal });
		})})})});

 		^super.new1(rate, selector, a, b)
	}
}

+ MulAdd { // 3.6.2
	*new1 { arg rate, in, mul, add;
		var minus, nomul, noadd;

		// eliminate degenerate cases
 		if (mul == 0.0, { ^DC.multiNew(rate, add) });
		minus = mul == -1.0;
		nomul = mul == 1.0;
		noadd = add == 0.0;
 		if (nomul && noadd, { ^in });
 		if (minus && noadd, { ^in.neg });
 		if (noadd, { ^in * mul });
  		if (minus, { ^add - in });
		if (nomul, { ^in + add });

		if (this.canBeMulAdd(in, mul, add)) {
			^super.new1(rate, in, mul, add)
		};
		if (this.canBeMulAdd(mul, in, add)) {
			^super.new1(rate, mul, in, add)
		};
		^( (in * mul) + add)
	}
}