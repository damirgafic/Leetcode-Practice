def shuffle(nums, n): 
  final_list = []
  for i in range(n): 
    final_list.append(nums[i])
    #final_list[i*n+1]=nums[n+i]
    final_list.append(nums[n+i])
  return final_list
  
  Runtime: 56ms
