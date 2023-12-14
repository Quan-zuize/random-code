using System;

namespace Algorithm
{
    class Program
    {
        static class Constants
        {
            public const int SIZE = 10; // km per sec.
        }

        static void Main(string[] args)
        {
            //int size = Constants.SIZE;
            //int i, j, N;
            //int[,] board = new int[size, size];
            //int left, top;

            //left = 0;
            //top = size - 1;
            //N = 1;

            //for (i = 1; i <= size / 2; i++, left++, top--)
            //{
            //    // Fill from left to right
            //    for (j = left; j <= top; j++, N++)
            //    {
            //        board[left,j] = N;
            //    }

            //    // Fill from top to down
            //    for (j = left + 1; j <= top; j++, N++)
            //    {
            //        board[j,top] = N;
            //    }

            //    // Fill from right to left
            //    for (j = top - 1; j >= left; j--, N++)
            //    {
            //        board[top,j] = N;
            //    }

            //    // Fill from down to top
            //    for (j = top - 1; j >= left + 1; j--, N++)
            //    {
            //        board[j,left] = N;
            //    }
            //}

            //// Print the pattern
            //for (i = 0; i < size; i++)
            //{
            //    for (j = 0; j < size; j++)
            //    {
            //        Console.Write("{0, -5}", board[i,j]);
            //    }
            //    Console.WriteLine();
            //}

            Console.WriteLine("Input size : ");
            int size = Convert.ToInt32(Console.ReadLine());
            int[,] a = new int[size, size * 2];
            build_traingle_matrix(size, a, size, 1);
            for (int r = 0; r < size; ++r)
            {
                for (int d = size - r; d > 0; d--)
                {
                    Console.Write(' ');
                }
                for (int c = 0; c < size * 2; ++c)
                    if (a[r, c] != 0)
                    {
                        Console.Write("{0}", a[r, c]);
                    }
                Console.WriteLine();
            }
            //find_most_profit();
        }

        private static void find_most_profit()
        {
            int[] a = { 100, 120, 160, 90, 160};
            int import = a[0];
            int[] profit = new int[a.Length];
            //int profits = 0;
            for (int i = 1; i < a.Length; i++)
            {
                if(a[i] > import)
                {
                    profit[i] = a[i] - import;
                    //if (a[i] - import > profits)
                    //{
                    //    profits = a[i] - import;
                    //}
                }
                else
                {
                    import = a[i];
                }
            }
            Array.Sort(profit);
            Array.Reverse(profit);
            Console.WriteLine(profit[0]);
            //Console.WriteLine(profits);
        }

        private static void build_square_matrix(int msize, int[,] a, int size, int value)
        {
            int i, row, col;
            if (size < 1)
                return;
            row = col = (msize - size) / 2;
            if (size == 1)
            {
                a[row, col] = value;
                return;
            }

            for (i = 0; i < size - 1; ++i)
            {
                a[row, col++] = value++;//RIGHT
                if (value > 9)
                {
                    value = 1;
                }
            }

            for (i = 0; i < size - 1; ++i)
            {
                a[row++, col] = value++;//DOWN
                if (value > 9)
                {
                    value = 1;
                }
            }

            for (i = 0; i < size - 1; ++i)
            {
                a[row, col--] = value++;//LEFT
                if (value > 9)
                {
                    value = 1;
                }
            }

            for (i = 0; i < size - 1; ++i)
            {
                a[row--, col] = value++;//UP
                if (value > 9)
                {
                    value = 1;
                }
            }
            build_square_matrix(msize, a, size - 2, value);
        }

        private static void build_traingle_matrix(int msize, int[,] a, int size, int value)
        {
            int i, row, col;
            if (size < 1)
                return;

            row = (msize - size) / 2;
            col = msize;
            if (size == 1)
            {
                a[row, col] = value;
                return;
            }
            //if (size == 1)
            //{
            //    a[row, col] = value;
            //    return;
            //}

            //while (k != 2 * i - 1)
            //{

            //}
            for (i = 0; i < size - 1; ++i)
            {
                a[row++, col++] = value++;//DOWN
                if (value > 9)
                {
                    value = 1;
                }
            }

            for (i = 0; i < size * 2 - 2; ++i)
            {
                a[row, col--] = value++;//LEFT
                if (value > 9)
                {
                    value = 1;
                }
            }
            for (i = 0; i < size - 1; ++i)
            {
                a[row--, col++] = value++;//UP
                if (value > 9)
                {
                    value = 1;
                }
            }
            build_traingle_matrix(msize, a, size - 2, value);
        }
    }
}
