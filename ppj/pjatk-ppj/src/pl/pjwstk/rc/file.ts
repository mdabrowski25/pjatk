class App {
    solve(steps: number) {
        return this.getFiboNumber(steps + 1);
    }

    getFiboNumber(integer: number) {
        let x1 = 1;
        let x2 = 1;
        for (let i = 3; i <= integer; i++) {
            let temp = x1 + x2;
            x1 = x2;
            x2 = temp;
        }
        return x2;
    }
}
