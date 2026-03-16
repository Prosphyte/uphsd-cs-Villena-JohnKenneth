/**
 * =====================================================
 * Student Name    : Villena, John Kenneth M.
 * Course          : Math 101 - Linear Algebra
 * Assignment      : Programming Assignment 1 - 3x3 Matrix Determinant Solver
 * School          : University of Perpetual Help System DALTA, Molino Campus
 * Date            : march 16, 2026
 * GitHub Repo     : https://github.com/Prosphyte/uphsd-cs-Villena-JohnKenneth
 *
 * Description:
 *   This program computes the determinant of a hardcoded 3x3 matrix assigned
 *   to Villena, John Kenneth M. for Math 101. The solution is computed using cofactor
 *   expansion along the first row. Each intermediate step (2x2 minor,
 *   cofactor term, running sum) is printed to the console in a readable format.
 * =====================================================
 */
public class DeterminantSolver {
    // hardcoded 3x3 matrix in a multidimensional array.
    static int[][] matrix = {
        { 1, 4, 6 },   // Row 1 of assigned matrix
        { 3, 5, 2 },   // Row 2 of assigned matrix
        { 4, 1, 3 }    // Row 3 of assigned matrix
    };

    // determinant of a 2x2 matrix given its four elements. Used to compute the minors.
    static int computeMinor(int a, int b, int c, int d) {
        // Apply the 2x2 determinant formula: ad - bc
        return (a * d) - (b * c);
    }

    // border for the 3x3 matrix
    static void printMatrix(int[][] m) {
        System.out.println("┌              ┐");
        for (int[] row : m) {
            System.out.printf("│  %2d  %2d  %2d  │%n", row[0], row[1], row[2]);
        }
        System.out.println("└              ┘");
    }

    // cofactor expansion logic to compute the determinant of the 3x3 matrix.
    static void solveDeterminant(int[][] m) {

        // readable display of matrix
        System.out.println("=".repeat(52));
        System.out.println("  3x3 MATRIX DETERMINANT SOLVER");
        System.out.println("  Student: Villena, John Kenneth M.");
        System.out.println("  Assigned Matrix:");
        System.out.println("=".repeat(52));
        printMatrix(m);
        System.out.println("=".repeat(52));

        // m11 computation, remove row 0 and column 0.
        int minor11 = computeMinor(m[1][1], m[1][2], m[2][1], m[2][2]);
        System.out.printf("  Step 1 - Minor M₁₁: det([%d,%d],[%d,%d]) = (%d*%d)-(%d*%d) = %d%n",
            m[1][1], m[1][2], m[2][1], m[2][2],
            m[1][1], m[2][2], m[1][2], m[2][1], minor11);

        // same step as above but remove row 0 and column 1.
        int minor12 = computeMinor(m[1][0], m[1][2], m[2][0], m[2][2]);
        System.out.printf("  Step 2 - Minor M₁₂: det([%d,%d],[%d,%d]) = (%d*%d)-(%d*%d) = %d%n",
            m[1][0], m[1][2], m[2][0], m[2][2],
            m[1][0], m[2][2], m[1][2], m[2][0], minor12);

        // remove row 0 and column 2.
        int minor13 = computeMinor(m[1][0], m[1][1], m[2][0], m[2][1]);
        System.out.printf("  Step 3 - Minor M₁₃: det([%d,%d],[%d,%d]) = (%d*%d)-(%d*%d) = %d%n",
            m[1][0], m[1][1], m[2][0], m[2][1],
            m[1][0], m[2][1], m[1][1], m[2][0], minor13);

        // now we multiply the row we removed with the minor we computed. We also apply the sign based on the position of the element in the original matrix.
        int c11 =  m[0][0] * minor11;
        int c12 = -m[0][1] * minor12;
        int c13 =  m[0][2] * minor13;

        System.out.println();
        System.out.printf("  Cofactor C₁₁ = (+1) * %d * %d = %d%n", m[0][0], minor11, c11);
        System.out.printf("  Cofactor C₁₂ = (-1) * %d * %d = %d%n", m[0][1], minor12, c12);
        System.out.printf("  Cofactor C₁₃ = (+1) * %d * %d = %d%n", m[0][2], minor13, c13);

        // add to get the determinant of the original 3x3 matrix.
        int det = c11 + c12 + c13;
        System.out.printf("%n  det(M) = %d + (%d) + %d%n", c11, c12, c13);
        System.out.println("=".repeat(52));
        System.out.printf("  ✓  DETERMINANT = %d%n", det);

        // ── Singular Matrix Check ──
        // A determinant of zero means the matrix is singular (non-invertible).
        if (det == 0) {
            System.out.println("  ⚠ The matrix is SINGULAR - it has no inverse.");
        }
        System.out.println("=".repeat(52));
    }

    // main method to execute the determinant solver. Calls the solveDeterminant method
    public static void main(String[] args) {
        solveDeterminant(matrix);
    }

}