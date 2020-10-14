def shuffle(nums, n): 
  final_list = []
  for i in range(n): 
    final_list.append(nums[i])
    #final_list[i*n+1]=nums[n+i]
    final_list.append(nums[n+i])
  return final_list
  
  Runtime: 56ms

    
  Defanging an IP Address 
  def defangIPaddr(self, address: str) -> str:
        defang = ''
        for i in range(len(address)): 
            if address[i] == '.':
                defang += ('[.]')
            else:
                defang += (address[i])
        return defang
  Runtime: 32s
