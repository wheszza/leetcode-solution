/*
 * @Author: whe
 * @Date: 2022-03-01 10:44:03
 */
package solution

func convert(s string, numRows int) string {
	buffer := []byte{}
	if numRows == 1 {
		return s
	}
	for i := 0; i < numRows; i++ {
		//z字两端直接写入
		if i == 0 || i == numRows-1 {
			for j := i; j < len(s); j += 2*numRows - 2 {
				buffer = append(buffer, s[j])
			}
		} else {
			// z字中间同一行取模后相加为固定值
			for j := i; j < len(s); j += 2*numRows - 2 {
				buffer = append(buffer, s[j])
				n := j + 2*numRows - 2 - j%(2*numRows-2)*2
				if n < len(s) {
					buffer = append(buffer, s[n])
				}
			}
		}
	}
	return string(buffer)
}
